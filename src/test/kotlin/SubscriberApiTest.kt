import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.Channel
import co.novu.dto.ChannelCredentials
import co.novu.dto.Preference
import co.novu.dto.Template
import co.novu.dto.request.Mark
import co.novu.dto.request.MarkMessageActionAsSeenRequest
import co.novu.dto.request.MarkSubscriberFeedAsRequest
import co.novu.dto.request.SubscriberRequest
import co.novu.dto.request.UpdateSubscriberCredentialsRequest
import co.novu.dto.request.UpdateSubscriberRequest
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.SubscriberDeleteResponse
import co.novu.dto.response.SubscriberNotificationResponse
import co.novu.dto.response.SubscriberPreferenceResponse
import co.novu.dto.response.SubscriberResponse
import co.novu.dto.response.UnseenNotificationsCountResponse
import co.novu.dto.response.UpdateSubscriberPreferencesRequest
import co.novu.extensions.createSubscriber
import co.novu.extensions.deleteSubscriber
import co.novu.extensions.markMessageActionSeen
import co.novu.extensions.markSubscriberFeed
import co.novu.extensions.subscriber
import co.novu.extensions.subscriberNotificationsFeed
import co.novu.extensions.subscriberPreferences
import co.novu.extensions.subscriberUnseenNotificationsCount
import co.novu.extensions.subscribers
import co.novu.extensions.updateSubscriber
import co.novu.extensions.updateSubscriberCredentials
import co.novu.extensions.updateSubscriberOnlineStatus
import co.novu.extensions.updateSubscriberPreferences
import com.google.gson.Gson
import com.google.gson.JsonParser
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test
import java.math.BigInteger

@OptIn(ExperimentalCoroutinesApi::class)
class SubscriberApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        NovuConfig(apiKey = "1245", backendUrl = mockWebServer.url("").toString())
    )

    @Test
    fun testGetSubscribers() = runTest {
        val responseBody = PaginatedResponseWrapper(
            data = listOf(
                SubscriberResponse(
                    _id = "123",
                    _organizationId = "123",
                    _environmentId = "123",
                    deleted = false,
                    createdAt = "123",
                    updatedAt = "123",
                    locale = "123",
                    __v = BigInteger.TEN,
                    isOnline = false,
                    lastOnlineAt = "123",
                    firstName = "123",
                    lastName = "123",
                    email = "123",
                    phone = "123",
                    avatar = "123",
                    subscriberId = "123",
                    channels = listOf(
                        Channel(
                            credentials = ChannelCredentials(
                                webhookUrl = "webhookUrl",
                                deviceTokens = listOf("deviceTokens")
                            )
                        )
                    )
                )
            ),
            totalCount = BigInteger.TEN
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val result = mockNovu.subscribers(BigInteger.TEN)
        val request = mockWebServer.takeRequest()
        assert(request.path == "/subscribers?page=10")
        assert(request.method == "GET")
        assert(Gson().toJson(result) == Gson().toJson(responseBody))
    }

    @Test
    fun testCreateSubscriber() = runTest {
        val responseBody = ResponseWrapper(
            SubscriberResponse(
                subscriberId = "123",
                _id = "123",
                _organizationId = "123",
                _environmentId = "123",
                deleted = false,
                createdAt = "123",
                updatedAt = "123",
                locale = "123",
                __v = BigInteger.TEN,
                isOnline = false,
                lastOnlineAt = "123",
                firstName = "123",
                lastName = "123",
                email = "123",
                phone = "123",
                avatar = "123",
                channels = listOf(
                    Channel(
                        credentials = ChannelCredentials(
                            webhookUrl = "webhookUrl",
                            deviceTokens = listOf("deviceTokens")
                        )
                    )
                )
            )

        )
        mockWebServer.enqueue(MockResponse().setResponseCode(201).setBody(Gson().toJson(responseBody)))
        val requestBody = SubscriberRequest(
            firstName = "123",
            lastName = "123",
            email = "123",
            phone = "123",
            avatar = "123",
            subscriberId = "123"
        )
        JsonParser().parse(Gson().toJson(requestBody)).toString()

        val result = mockNovu.createSubscriber(requestBody)
        val request = mockWebServer.takeRequest()
        assert(request.path == "/subscribers")
        assert(request.method == "POST")
        assert(JsonParser().parse(Gson().toJson(requestBody)) == JsonParser().parse(request.body.readUtf8()))
        assert(Gson().toJson(result) == Gson().toJson(responseBody))
    }

    @Test
    fun testUpdateSubscriber() = runTest {
        val responseBody = ResponseWrapper(
            SubscriberResponse(
                subscriberId = "123",
                _id = "123",
                _organizationId = "123",
                _environmentId = "123",
                deleted = false,
                createdAt = "123",
                updatedAt = "123",
                locale = "123",
                __v = BigInteger.TEN,
                isOnline = false,
                lastOnlineAt = "123",
                firstName = "123",
                lastName = "123",
                email = "123",
                phone = "123",
                avatar = "123",
                channels = listOf(
                    Channel(
                        credentials = ChannelCredentials(
                            webhookUrl = "webhookUrl",
                            deviceTokens = listOf("deviceTokens")
                        )
                    )
                )
            )

        )
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val requestBody = UpdateSubscriberRequest(
            firstName = "123",
            lastName = "123",
            email = "123",
            phone = "123",
            avatar = "123"
        )
        val subscriberId = "123"
        val result = mockNovu.updateSubscriber(subscriberId, requestBody)
        val request = mockWebServer.takeRequest()
        assert(request.path == "/subscribers/$subscriberId")
        assert(request.method == "PUT")
        assert(Gson().toJson(result) == Gson().toJson(responseBody))
        assert(JsonParser().parse(Gson().toJson(requestBody)) == JsonParser().parse(request.body.readUtf8()))
    }

    @Test
    fun testGetSubscriber() = runTest {
        val responseBody = ResponseWrapper(
            SubscriberResponse(
                subscriberId = "123",
                _id = "123",
                _organizationId = "123",
                _environmentId = "123",
                deleted = false,
                createdAt = "123",
                updatedAt = "123",
                locale = "123",
                __v = BigInteger.TEN,
                isOnline = false,
                lastOnlineAt = "123",
                firstName = "123",
                lastName = "123",
                email = "123",
                phone = "123",
                avatar = "123",
                channels = listOf(
                    Channel(
                        credentials = ChannelCredentials(
                            webhookUrl = "webhookUrl",
                            deviceTokens = listOf("deviceTokens")
                        )
                    )
                )
            )
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val subscriberId = "123"
        val result = mockNovu.subscriber(subscriberId)
        val request = mockWebServer.takeRequest()
        assert(request.path == "/subscribers/$subscriberId")
        assert(request.method == "GET")
        assert(Gson().toJson(result) == Gson().toJson(responseBody))
    }

    @Test
    fun testDeleteSubscriber() = runTest {
        val responseBody = ResponseWrapper(
            SubscriberDeleteResponse(
                acknowledged = true,
                status = "status"
            )
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val subscriberId = "123"
        val result = mockNovu.deleteSubscriber(subscriberId)
        val request = mockWebServer.takeRequest()
        assert(request.path == "/subscribers/$subscriberId")
        assert(request.method == "DELETE")
        assert(result == responseBody)
    }

    @Test
    fun testUpdateSubscriberCredentials() = runTest {
        val responseBody = ResponseWrapper(
            SubscriberResponse(
                subscriberId = "123",
                _id = "123",
                _organizationId = "123",
                _environmentId = "123",
                deleted = false,
                createdAt = "123",
                updatedAt = "123",
                locale = "123",
                __v = BigInteger.TEN,
                isOnline = false,
                lastOnlineAt = "123",
                firstName = "123",
                lastName = "123",
                email = "123",
                phone = "123",
                avatar = "123",
                channels = listOf(
                    Channel(
                        credentials = ChannelCredentials(
                            webhookUrl = "webhookUrl",
                            deviceTokens = listOf("deviceTokens")
                        )
                    )
                )
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val requestBody = UpdateSubscriberCredentialsRequest(
            providerId = "123",
            credentials = ChannelCredentials(
                webhookUrl = "webhookUrl",
                deviceTokens = listOf("deviceTokens")
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val result = mockNovu.updateSubscriberCredentials("123", requestBody)
        val request = mockWebServer.takeRequest()
        val subscriberId = "123"
        assert(request.path == "/subscribers/$subscriberId/credentials")
        assert(request.method == "PUT")
        assert(Gson().toJson(result) == Gson().toJson(responseBody))
    }

    @Test
    fun testUpdateSubscriberOnlineStatus() = runTest {
        val responseBody = ResponseWrapper(
            SubscriberResponse(
                subscriberId = "123",
                _id = "123",
                _organizationId = "123",
                _environmentId = "123",
                deleted = false,
                createdAt = "123",
                updatedAt = "123",
                locale = "123",
                __v = BigInteger.TEN,
                isOnline = false,
                lastOnlineAt = "123",
                firstName = "123",
                lastName = "123",
                email = "123",
                phone = "123",
                avatar = "123",
                channels = listOf(
                    Channel(
                        credentials = ChannelCredentials(
                            webhookUrl = "webhookUrl",
                            deviceTokens = listOf("deviceTokens")
                        )
                    )
                )
            )
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val subscriberId = "123"
        val isOnline = false
        val result = mockNovu.updateSubscriberOnlineStatus(subscriberId, isOnline)
        val request = mockWebServer.takeRequest()
        assert(request.path == "/subscribers/$subscriberId/online-status")
        assert(request.method == "PATCH")
        assert(Gson().toJson(result) == Gson().toJson(responseBody))
    }

    @Test
    fun testGetSubscriberPreferences() = runTest {
        val responseBody = ResponseWrapper(
            listOf(
                SubscriberPreferenceResponse(
                    template = Template(
                        _id = "123",
                        name = "name",
                        critical = true
                    ),
                    preference = Preference(
                        enabled = true,
                        channels = "channels"
                    )
                )
            )
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val result = mockNovu.subscriberPreferences("123")
        val request = mockWebServer.takeRequest()
        val susbcriberId = "123"
        assert(request.path == "/subscribers/$susbcriberId/preferences")
        assert(request.method == "GET")
        assert(result == responseBody)
    }

    @Test
    fun testUpdateSubscriberPreferences() = runTest {
        val responseBody = ResponseWrapper(
            SubscriberPreferenceResponse(
                template = Template(
                    _id = "123",
                    name = "name",
                    critical = true
                ),
                preference = Preference(
                    enabled = true,
                    channels = "channels"
                )
            )
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val requestBody = UpdateSubscriberPreferencesRequest(
            channel = "channel",
            enabled = true
        )
        val susbcriberId = "123"
        val templateId = "123"

        val result = mockNovu.updateSubscriberPreferences(susbcriberId, templateId, requestBody)
        val request = mockWebServer.takeRequest()
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(request.path == "/subscribers/$susbcriberId/preferences/$templateId")
        assert(request.method == "PATCH")
        assert(result == responseBody)
    }

    @Test
    fun testGetNotificationFeedForSubscribers() = runTest {
        val responseBody = PaginatedResponseWrapper(
            data = listOf(
                SubscriberNotificationResponse(
                    _id = "123",
                    _organizationId = "_organizationId",
                    _environmentId = "_environmentId",
                    _messageTemplateId = "_messageTemplateId",
                    _subscriberId = "_subscriberId",
                    subscriber = "subscriber",
                    template = "template",
                    templateIdentifier = "templateIdentifier",
                    createdAt = "createdAt",
                    content = "content",
                    transactionId = "transactionId",
                    channel = "channel",
                    seen = true,
                    email = "email@email.com",
                    phone = "phone",
                    status = "status",
                    directWebhookUrl = "directWebhookUrl",
                    providerId = "providerId",
                    deviceTokens = listOf("deviceTokens"),
                    title = "title",
                    lastSeenDate = "lastSeenDate",
                    cta = "cta",
                    _feedId = "_feedId",
                    errorId = "errorId",
                    errorText = "errorText",
                    payload = "payload",
                    overrides = "overrides",
                    subject = "subject",
                    _notificationId = "_notificationId",
                    _templateId = "_templateId"
                )
            ),
            totalCount = BigInteger.TEN
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val susbcriberId = "123"
        val result = mockNovu.subscriberNotificationsFeed(subscriberId = susbcriberId)
        val request = mockWebServer.takeRequest()
        assert(request.path == "/subscribers/$susbcriberId/notifications/feed")
        assert(request.method == "GET")
        assert(result == responseBody)
    }

    @Test
    fun testGetSubscriberUnseenNotificationsCount() = runTest {
        val responseBody = ResponseWrapper(
            UnseenNotificationsCountResponse(
                count = BigInteger.TEN
            )
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val result = mockNovu.subscriberUnseenNotificationsCount("123")
        val request = mockWebServer.takeRequest()
        val subscriberId = "123"
        assert(request.path == "/subscribers/$subscriberId/notifications/unseen")
        assert(request.method == "GET")
        assert(result == responseBody)
    }

    @Test
    fun testMarkSubscriberFeedAs() = runTest {
        val responseBody = ResponseWrapper(
            SubscriberNotificationResponse(
                _id = "123",
                _organizationId = "_organizationId",
                _environmentId = "_environmentId",
                _messageTemplateId = "_messageTemplateId",
                _subscriberId = "_subscriberId",
                subscriber = "subscriber",
                template = "template",
                templateIdentifier = "templateIdentifier",
                createdAt = "createdAt",
                content = "content",
                transactionId = "transactionId",
                channel = "channel",
                seen = true,
                email = "email@email.com",
                phone = "phone",
                status = "status",
                directWebhookUrl = "directWebhookUrl",
                providerId = "providerId",
                deviceTokens = listOf("deviceTokens"),
                title = "title",
                lastSeenDate = "lastSeenDate",
                cta = "cta",
                _feedId = "_feedId",
                errorId = "errorId",
                errorText = "errorText",
                payload = "payload",
                overrides = "overrides",
                subject = "subject",
                _notificationId = "_notificationId",
                _templateId = "_templateId"
            )
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(201).setBody(Gson().toJson(responseBody)))
        val requestBody = MarkSubscriberFeedAsRequest(
            messageId = listOf("123"),
            mark = Mark(
                read = true,
                seen = true
            )
        )
        val result = mockNovu.markSubscriberFeed("123", requestBody)
        val request = mockWebServer.takeRequest()
        val subscriberId = "123"
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(request.path == "/subscribers/$subscriberId/messages/markAs")
        assert(request.method == "POST")
        assert(result == responseBody)
    }

    @Test
    fun testMarkMessageActionAsSeen() = runTest {
        val responseBody = ResponseWrapper(
            SubscriberNotificationResponse(
                _id = "123",
                _organizationId = "_organizationId",
                _environmentId = "_environmentId",
                _messageTemplateId = "_messageTemplateId",
                _subscriberId = "_subscriberId",
                subscriber = "subscriber",
                template = "template",
                templateIdentifier = "templateIdentifier",
                createdAt = "createdAt",
                content = "content",
                transactionId = "transactionId",
                channel = "channel",
                seen = true,
                email = "email@email.com",
                phone = "phone",
                status = "status",
                directWebhookUrl = "directWebhookUrl",
                providerId = "providerId",
                deviceTokens = listOf("deviceTokens"),
                title = "title",
                lastSeenDate = "lastSeenDate",
                cta = "cta",
                _feedId = "_feedId",
                errorId = "errorId",
                errorText = "errorText",
                payload = "payload",
                overrides = "overrides",
                subject = "subject",
                _notificationId = "_notificationId",
                _templateId = "_templateId"
            )
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(201).setBody(Gson().toJson(responseBody)))
        val subscriberId = "123"
        val messageId = "123"
        val type = "type"
        val requestBody = MarkMessageActionAsSeenRequest(
            status = "status"
        )
        val result = mockNovu.markMessageActionSeen(subscriberId, messageId, type, requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(request.path == "/subscribers/$subscriberId/messages/$messageId/actions/$type")
        assert(request.method == "POST")
        assert(result == responseBody)
    }
}
