import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.Children
import co.novu.dto.Filters
import co.novu.dto.Metadata
import co.novu.dto.NotificationGroup
import co.novu.dto.PreferenceSettings
import co.novu.dto.Step
import co.novu.dto.Trigger
import co.novu.dto.Variables
import co.novu.dto.request.UpdateWorkflowRequest
import co.novu.dto.request.UpdateWorkflowStatusRequest
import co.novu.dto.request.WorkflowRequest
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.WorkflowResponse
import co.novu.extensions.createWorkflow
import co.novu.extensions.deleteWorkflow
import co.novu.extensions.getWorkflow
import co.novu.extensions.getWorkflows
import co.novu.extensions.updateWorkflow
import co.novu.extensions.updateWorkflowStatus
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test
import java.math.BigInteger

@OptIn(ExperimentalCoroutinesApi::class)
class WorkflowsApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        NovuConfig(apiKey = "1245", backendUrl = mockWebServer.url("").toString())
    )

    @Test
    fun testGetWorkflows() = runTest {
        val responseBody = PaginatedResponseWrapper(
            data = listOf(
                WorkflowResponse(
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
                            filters = listOf(
                                Filters(
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
                                )
                            ),
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
                            replyCallback = "replyCallback"
                        )
                    ),
                    _organizationId = "_organizationId",
                    _creatorId = "_creatorId",
                    _environmentId = "_environmentId",
                    triggers = listOf(
                        Trigger(
                            type = "type",
                            identifier = "identifier",
                            variables = listOf(
                                Variables(
                                    name = "name"
                                )
                            ),
                            subscriberVariables = listOf(
                                Variables(
                                    name = "name"
                                )
                            )
                        )
                    ),
                    notificationGroupId = "_notificationGroupId",
                    deleted = true,
                    deletedBy = "deletedBy",
                    notificationGroup = NotificationGroup(
                        _id = "_id",
                        name = "name",
                        _environmentId = "_environmentId",
                        _organizationId = "_organizationId",
                        _parentId = "_parentId"
                    )
                )
            )

        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val page = 1
        val limit = 10
        val result = mockNovu.getWorkflows(page, limit)
        val request = mockWebServer.takeRequest()

        assert(request.method == "GET")
        assert(request.path == "/workflows?page=$page&limit=$limit")
        assert(Gson().toJson(responseBody) == Gson().toJson(result))
    }

    @Test
    fun testCreateWorkflow() = runTest {
        val responseBody = ResponseWrapper(
            WorkflowResponse(
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
                        filters = listOf(
                            Filters(
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
                            )
                        ),
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
                        replyCallback = "replyCallback"
                    )
                ),
                _organizationId = "_organizationId",
                _creatorId = "_creatorId",
                _environmentId = "_environmentId",
                triggers = listOf(
                    Trigger(
                        type = "type",
                        identifier = "identifier",
                        variables = listOf(
                            Variables(
                                name = "name"
                            )
                        ),
                        subscriberVariables = listOf(
                            Variables(
                                name = "name"
                            )
                        )
                    )
                ),
                notificationGroupId = "_notificationGroupId",
                deleted = true,
                deletedBy = "deletedBy",
                notificationGroup = NotificationGroup(
                    _id = "_id",
                    name = "name",
                    _environmentId = "_environmentId",
                    _organizationId = "_organizationId",
                    _parentId = "_parentId"
                )
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(201).setBody(Gson().toJson(responseBody)))
        val requestBody = WorkflowRequest()
        requestBody.name = "name"
        requestBody.description = "description"
        requestBody.active = true
        requestBody.draft = true
        requestBody.preferenceSettings = PreferenceSettings(
            email = true,
            sms = true,
            push = true,
            inApp = true,
            chat = true
        )
        requestBody.critical = true
        requestBody.tags = listOf("tag1", "tag2")
        requestBody.steps = listOf(
            Step(
                active = true,
                template = "template",
                filters = listOf(
                    Filters(
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
                    )
                )
            )
        )
        val result = mockNovu.createWorkflow(requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "POST")
        assert(request.path == "/workflows")
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(Gson().toJson(responseBody) == Gson().toJson(result))
    }

    @Test
    fun testUpdateWorkflow() = runTest {
        val responseBody = ResponseWrapper(
            WorkflowResponse(
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
                        filters = listOf(
                            Filters(
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
                            )
                        ),
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
                        replyCallback = "replyCallback"
                    )
                ),
                _organizationId = "_organizationId",
                _creatorId = "_creatorId",
                _environmentId = "_environmentId",
                triggers = listOf(
                    Trigger(
                        type = "type",
                        identifier = "identifier",
                        variables = listOf(
                            Variables(
                                name = "name"
                            )
                        ),
                        subscriberVariables = listOf(
                            Variables(
                                name = "name"
                            )
                        )
                    )
                ),
                notificationGroupId = "_notificationGroupId",
                deleted = true,
                deletedBy = "deletedBy",
                notificationGroup = NotificationGroup(
                    _id = "_id",
                    name = "name",
                    _environmentId = "_environmentId",
                    _organizationId = "_organizationId",
                    _parentId = "_parentId"
                )
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val requestBody = UpdateWorkflowRequest()
        requestBody.identifier = "id"
        requestBody.name = "name"
        requestBody.description = "description"
        requestBody.active = true
        requestBody.draft = true
        requestBody.preferenceSettings = PreferenceSettings(
            email = true,
            sms = true,
            push = true,
            inApp = true,
            chat = true
        )
        requestBody.critical = true
        requestBody.tags = listOf("tag1", "tag2")
        requestBody.steps = listOf(
            Step(
                active = true,
                template = "template",
                filters = listOf(
                    Filters(
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
                    )
                )
            )
        )
        val workflowId = "_id"
        val result = mockNovu.updateWorkflow(workflowId, requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "PUT")
        assert(request.path == "/workflows/$workflowId")
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(Gson().toJson(responseBody) == Gson().toJson(result))
    }

    @Test
    fun testDeleteWorkflow() = runTest {
        val responseBody = ResponseWrapper(true)
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))

        val workflowId = "_id"
        val result = mockNovu.deleteWorkflow(workflowId)
        val request = mockWebServer.takeRequest()

        assert(request.method == "DELETE")
        assert(request.path == "/workflows/$workflowId")
        assert(Gson().toJson(responseBody) == Gson().toJson(result))
    }

    @Test
    fun testGetWorkflow() = runTest {
        val responseBody = ResponseWrapper(
            WorkflowResponse(
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
                        filters = listOf(
                            Filters(
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
                            )
                        ),
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
                        replyCallback = "replyCallback"
                    )
                ),
                _organizationId = "_organizationId",
                _creatorId = "_creatorId",
                _environmentId = "_environmentId",
                triggers = listOf(
                    Trigger(
                        type = "type",
                        identifier = "identifier",
                        variables = listOf(
                            Variables(
                                name = "name"
                            )
                        ),
                        subscriberVariables = listOf(
                            Variables(
                                name = "name"
                            )
                        )
                    )
                ),
                notificationGroupId = "_notificationGroupId",
                deleted = true,
                deletedBy = "deletedBy",
                notificationGroup = NotificationGroup(
                    _id = "_id",
                    name = "name",
                    _environmentId = "_environmentId",
                    _organizationId = "_organizationId",
                    _parentId = "_parentId"
                )
            )
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))

        val workflowId = "_id"
        val result = mockNovu.getWorkflow(workflowId)
        val request = mockWebServer.takeRequest()

        assert(request.method == "GET")
        assert(request.path == "/workflows/$workflowId")
        assert(Gson().toJson(responseBody) == Gson().toJson(result))
    }

    @Test
    fun testUpdateWorkflowStatus() = runTest {
        val responseBody = ResponseWrapper(
            WorkflowResponse(
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
                        filters = listOf(
                            Filters(
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
                            )
                        ),
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
                        replyCallback = "replyCallback"
                    )
                ),
                _organizationId = "_organizationId",
                _creatorId = "_creatorId",
                _environmentId = "_environmentId",
                triggers = listOf(
                    Trigger(
                        type = "type",
                        identifier = "identifier",
                        variables = listOf(
                            Variables(
                                name = "name"
                            )
                        ),
                        subscriberVariables = listOf(
                            Variables(
                                name = "name"
                            )
                        )
                    )
                ),
                notificationGroupId = "_notificationGroupId",
                deleted = true,
                deletedBy = "deletedBy",
                notificationGroup = NotificationGroup(
                    _id = "_id",
                    name = "name",
                    _environmentId = "_environmentId",
                    _organizationId = "_organizationId",
                    _parentId = "_parentId"
                )
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))

        val workflowId = "_id"
        val requestBody = UpdateWorkflowStatusRequest(
            active = true
        )

        val result = mockNovu.updateWorkflowStatus(workflowId, requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "PUT")
        assert(request.path == "/workflows/$workflowId/status")
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(Gson().toJson(responseBody) == Gson().toJson(result))
    }
}
