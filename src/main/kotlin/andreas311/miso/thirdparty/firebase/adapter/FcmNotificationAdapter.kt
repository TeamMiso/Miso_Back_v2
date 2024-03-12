package andreas311.miso.thirdparty.firebase.adapter

import andreas311.miso.domain.notification.application.port.output.FcmNotificationPort
import andreas311.miso.domain.notification.domain.NotificationAlarm
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.MulticastMessage
import com.google.firebase.messaging.Notification

class FcmNotificationAdapter: FcmNotificationPort {
    private val firebaseInstance: FirebaseMessaging
        get() = FirebaseMessaging.getInstance()

    override fun sendInquiryNotification(deviceToken: String, notificationAlarm: NotificationAlarm) {
        val message = getMassageBuilderByNotification(notificationAlarm)
            .setToken(deviceToken)
            .build()
        firebaseInstance.send(message)
    }

    override fun sendEnvironmentNotification(deviceTokens: List<String>, notificationAlarm: NotificationAlarm) {
        val message = getMulticastMassageBuilderByNotification(notificationAlarm)
            .addAllTokens(deviceTokens)
            .build()
        firebaseInstance.sendMulticastAsync(message)
    }

    private fun getMassageBuilderByNotification(notificationAlarm: NotificationAlarm) =
        with(notificationAlarm) {
            Message.builder()
                .setNotification(
                    Notification.builder()
                        .setTitle(title)
                        .setBody(content)
                        .build()
                )
        }

    private fun getMulticastMassageBuilderByNotification(notificationAlarm: NotificationAlarm) =
        with(notificationAlarm) {
            MulticastMessage.builder()
                .setNotification(
                    Notification.builder()
                        .setTitle(title)
                        .setBody(content)
                        .build()
                )
        }

}