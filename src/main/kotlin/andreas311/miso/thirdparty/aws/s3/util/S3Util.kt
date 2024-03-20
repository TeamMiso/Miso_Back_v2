package andreas311.miso.thirdparty.aws.s3.util

import andreas311.miso.thirdparty.aws.s3.exception.FileUploadFailedException
import andreas311.miso.thirdparty.aws.s3.exception.InvalidFormatFileException
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.util.*

@Component
class S3Util(
    private val amazonS3: AmazonS3
) {

    @Value("\${cloud.aws.s3.bucket}")
    lateinit var bucket: String

    fun execute(files: MultipartFile): String {

        val fileName = createFileName(files.originalFilename.toString())
        val objectMetadata = ObjectMetadata()
        objectMetadata.contentLength = files.size
        objectMetadata.contentType = files.contentType

        try {
            files.inputStream.use { inputStream ->
                amazonS3.putObject(PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead))
            }
        } catch (e: IOException) {
            throw FileUploadFailedException()
        }

        return generateFileUrl(fileName)
    }


    private fun createFileName(fileName: String): String {

        return UUID.randomUUID().toString() + getFileExtension(fileName)
    }

    private fun getFileExtension(fileName: String): String {
        try {
            return fileName.substring(fileName.lastIndexOf("."))
        } catch (e: StringIndexOutOfBoundsException) {
            throw InvalidFormatFileException()
        }
    }

    private fun generateFileUrl(fileName: String): String {

        return amazonS3.getUrl(bucket, fileName).toString()
    }
}