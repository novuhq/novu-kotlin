import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.*
import co.novu.dto.response.NotificationTemplates
import co.novu.extentions.createNotificationTemplates
import co.novu.extentions.getNotificationTemplates
import co.novu.extentions.updateNotificationTemplates
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test
import java.math.BigInteger

@OptIn(ExperimentalCoroutinesApi::class)
class NotificationTemplatesApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        apiKey = "1245",
        NovuConfig(backendUrl = mockWebServer.url("/"))
    )

    @Test
    fun testGetNotificationTemplates() = runTest {
        val responseBody = NotificationTemplates(
            _id = "_id",
            name = "name",
            description = "description",
            active = true,
            draft = true,
            preferenceSettings = PreferenceSettings(
                email = true,
                sms = true,
                push = true,
                inApp = true,
                chat = true
            ),
            critical = true,
            tags = listOf("tag1", "tag2"),
            steps = listOf(
                Step(
                    _id = "_id",
                    _templateId = "_templateId",
                    active = true,
                    shouldStopOnFail = true,
                    template = "template",
                    filters = listOf(Filters(
                        isNegated = true,
                        type = "type",
                        value = "value",
                        children = listOf(
                            Children(
                                field = "field",
                                value = "value",
                                operator = "operator",
                                on = "subscriber"
                            )
                        )
                    )),
                    metadata = Metadata(
                        amount = BigInteger.valueOf(10),
                        unit = "unit",
                        digestKey = "digestKey",
                        delayPath = "delayPath",
                        type = "type",
                        backoffUnit = "backoffUnit",
                        backoffAmount = BigInteger.valueOf(10),
                        updateMode = true
                    ),
                    _parentId = "_parentId",
                    replyCallback = "replyCallback",
                )
            ),
            _organizationId = "_organizationId",
            _creatorId = "_creatorId",
            _environmentId = "_environmentId",
            triggers = listOf(Trigger(
                type = "type",
                identifier = "identifier",
                variables = listOf(
                    Variables(
                        name = "name",
                    )
                ),
                subscriberVariables = listOf(
                    Variables(
                        name = "name",
                    )
                )
            )),
            _notificationGroupId = "_notificationGroupId",
            deleted = true,
            deletedBy = "deletedBy",
            notificationGroup = NotificationGroup(
                _id = "_id",
                name = "name",
                _environmentId = "_environmentId",
                _organizationId = "_organizationId",
                _parentId = "_parentId",
            ),
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val page = BigInteger.valueOf(1)
        val limit = BigInteger.valueOf(10)
        val result = mockNovu.getNotificationTemplates(page, limit)
        val request = mockWebServer.takeRequest()

        assert(request.method == "GET")
        assert(request.path == "/notification-templates?page=$page&limit=$limit")
        assert(Gson().toJson(responseBody) == Gson().toJson(result))
    }

    @Test
    fun testCreateNotification() = runTest {
        val responseBody = NotificationTemplates(
            _id = "_id",
            name = "name",
            description = "description",
            active = true,
            draft = true,
            preferenceSettings = PreferenceSettings(
                email = true,
                sms = true,
                push = true,
                inApp = true,
                chat = true
            ),
            critical = true,
            tags = listOf("tag1", "tag2"),
            steps = listOf(
                Step(
                    _id = "_id",
                    _templateId = "_templateId",
                    active = true,
                    shouldStopOnFail = true,
                    template = "template",
                    filters = listOf(Filters(
                        isNegated = true,
                        type = "type",
                        value = "value",
                        children = listOf(
                            Children(
                                field = "field",
                                value = "value",
                                operator = "operator",
                                on = "subscriber"
                            )
                        )
                    )),
                    metadata = Metadata(
                        amount = BigInteger.valueOf(10),
                        unit = "unit",
                        digestKey = "digestKey",
                        delayPath = "delayPath",
                        type = "type",
                        backoffUnit = "backoffUnit",
                        backoffAmount = BigInteger.valueOf(10),
                        updateMode = true
                    ),
                    _parentId = "_parentId",
                    replyCallback = "replyCallback",
                )
            ),
            _organizationId = "_organizationId",
            _creatorId = "_creatorId",
            _environmentId = "_environmentId",
            triggers = listOf(Trigger(
                type = "type",
                identifier = "identifier",
                variables = listOf(
                    Variables(
                        name = "name",
                    )
                ),
                subscriberVariables = listOf(
                    Variables(
                        name = "name",
                    )
                )
            )),
            _notificationGroupId = "_notificationGroupId",
            deleted = true,
            deletedBy = "deletedBy",
            notificationGroup = NotificationGroup(
                _id = "_id",
                name = "name",
                _environmentId = "_environmentId",
                _organizationId = "_organizationId",
                _parentId = "_parentId",
            ),
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(201).setBody(Gson().toJson(responseBody)))
        val requestBody = NotificationTemplates(
            name = "name",
            description = "description",
            active = true,
            draft = true,
            preferenceSettings = PreferenceSettings(
                email = true,
                sms = true,
                push = true,
                inApp = true,
                chat = true
            ),
            critical = true,
            tags = listOf("tag1", "tag2"),
            steps = listOf(
                Step(
                    active = true,
                    template = "template",
                    filters = listOf(Filters(
                        isNegated = true,
                        type = "type",
                        value = "value",
                        children = listOf(
                            Children(
                                field = "field",
                                value = "value",
                                operator = "operator",
                                on = "subscriber"
                            )
                        )
                    ))
                )
            )
        )
        val result = mockNovu.createNotificationTemplates(requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "POST")
        assert(request.path == "/notification-templates")
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(Gson().toJson(responseBody) == Gson().toJson(result))

    }

    @Test
    fun testUpdateNotificationTemplates() = runTest {
        val responseBody = NotificationTemplates(
            _id = "_id",
            name = "name",
            description = "description",
            active = true,
            draft = true,
            preferenceSettings = PreferenceSettings(
                email = true,
                sms = true,
                push = true,
                inApp = true,
                chat = true
            ),
            critical = true,
            tags = listOf("tag1", "tag2"),
            steps = listOf(
                Step(
                    _id = "_id",
                    _templateId = "_templateId",
                    active = true,
                    shouldStopOnFail = true,
                    template = "template",
                    filters = listOf(Filters(
                        isNegated = true,
                        type = "type",
                        value = "value",
                        children = listOf(
                            Children(
                                field = "field",
                                value = "value",
                                operator = "operator",
                                on = "subscriber"
                            )
                        )
                    )),
                    metadata = Metadata(
                        amount = BigInteger.valueOf(10),
                        unit = "unit",
                        digestKey = "digestKey",
                        delayPath = "delayPath",
                        type = "type",
                        backoffUnit = "backoffUnit",
                        backoffAmount = BigInteger.valueOf(10),
                        updateMode = true
                    ),
                    _parentId = "_parentId",
                    replyCallback = "replyCallback",
                )
            ),
            _organizationId = "_organizationId",
            _creatorId = "_creatorId",
            _environmentId = "_environmentId",
            triggers = listOf(Trigger(
                type = "type",
                identifier = "identifier",
                variables = listOf(
                    Variables(
                        name = "name",
                    )
                ),
                subscriberVariables = listOf(
                    Variables(
                        name = "name",
                    )
                )
            )),
            _notificationGroupId = "_notificationGroupId",
            deleted = true,
            deletedBy = "deletedBy",
            notificationGroup = NotificationGroup(
                _id = "_id",
                name = "name",
                _environmentId = "_environmentId",
                _organizationId = "_organizationId",
                _parentId = "_parentId",
            ),
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val requestBody = NotificationTemplates(
            name = "name",
            description = "description",
            active = true,
            preferenceSettings = PreferenceSettings(
                email = true,
                sms = true,
                push = true,
                inApp = true,
                chat = true
            ),
            critical = true,
            tags = listOf("tag1", "tag2"),
            steps = listOf(
                Step(
                    _id = "_id",
                    _templateId = "_templateId",
                    active = true,
                    template = "template",
                    filters = listOf(Filters(
                        isNegated = true,
                        type = "type",
                        value = "value",
                        children = listOf(
                            Children(
                                field = "field",
                                value = "value",
                                operator = "operator",
                                on = "subscriber"
                            )
                        )
                    )),
                    metadata = Metadata(
                        amount = BigInteger.valueOf(10),
                        unit = "unit",
                        digestKey = "digestKey",
                        delayPath = "delayPath",
                        type = "type",
                        backoffUnit = "backoffUnit",
                        backoffAmount = BigInteger.valueOf(10),
                        updateMode = true
                    ),
                    _parentId = "_parentId",
                    replyCallback = "replyCallback",
                ),
            ),
            _notificationGroupId = "_notificationGroupId",
        )
        val templateId = "_id"
        val result = mockNovu.updateNotificationTemplates(templateId, requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "PUT")
        assert(request.path == "/notification-templates/$templateId")
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(Gson().toJson(responseBody) == Gson().toJson(result))

    }
}
