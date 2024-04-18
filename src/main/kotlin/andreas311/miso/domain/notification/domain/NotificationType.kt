package andreas311.miso.domain.notification.domain

enum class NotificationType(
    val title: String,
    val body: String
) {

    INQUIRY_WAIT(
        title = "Miso 문의사항 등록 완료!",
        body = "최대한 빠르게 답변 드릴테니 기다려주세요 :)"
    ),

    INQUIRY_COMPLETE(
        title = "Miso 문의사항 답변 도착!",
        body = "내 문의 내역에서 답변을 확인해주세요 :)"
    ),

    ENVIRONMENT(
        title = "오늘의 환경 지식을 알고 싶다면?",
        body = "Miso 에서 오늘의 환경 지식을 확인해보세요 :)"
    )
}