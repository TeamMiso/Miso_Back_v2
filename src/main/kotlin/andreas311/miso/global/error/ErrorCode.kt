package andreas311.miso.global.error

enum class ErrorCode(
    val status: Int,
    val message: String
) {

    // SERVER ERROR
    UNKNOWN_ERROR(500, "알 수 없는 에러입니다."),

    // MAIL
    EMAIL_SEND_FAIL(500, "사용자를 찾을 수 없습니다."),

    // FILE
    INVALID_FORMAT_FILE(400, "잘못된 형식의 파일입니다."),
    FILE_UPLOAD_FAIL(500, "파일 업로드에 실패했습니다."),

    // TOKEN
    TOKEN_IS_EXPIRED(401, "토큰이 만료 되었습니다."),
    TOKEN_NOT_VALID(401, "토큰이 유효 하지 않습니다."),
    TOKEN_TYPE_NOT_VALID(401, "토큰 타입이 유효하지 않습니다"),

    // USER
    EMAIL_KEY_IS_INVALID(401, "이메일 인증번호가 일치하지 않습니다."),
    EMAIL_IS_NOT_VALID(403, "인증되지 않은 이메일입니다."),
    USER_NOT_FOUND(404, "사용자를 찾을 수 없습니다."),
    USER_ALREADY_EXIST(409, "이미 사용자가 존재합니다."),
    MISMATCH_PASSWORD(400, "비밀번호가 일치하지 않습니다."),

    // ITEM
    ITEM_NOT_FOUND(404, "상품을 찾을 수 없습니다."),
    ITEM_IS_SOLD_OUT(410, "상품의 재고가 남아있지 않습니다."),

    // PURCHASE
    POINT_IS_NOT_ENOUGH(403, "포인트가 부족합니다."),

    // INQUIRY
    INQUIRY_LOG_NOT_FOUND(404, "문의 내역을 찾을 수 없습니다."),

    // RECYCLABLES
    RECYCLABLES_NOT_FOUND(404, "분리수거 페이지를 찾을 수 없습니다."),

    // NOTIFICATION
    NOTIFICATION_NOT_FOUND(404, "문의 사항 답변을 찾을 수 없습니다."),

    // ENVIRONMENT
    ENVIRONMENT_NOT_FOUND(404, "환경 정보 글을 찾을 수 없습니다.")
}