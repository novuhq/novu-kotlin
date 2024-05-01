package co.novu

import api.WorkflowOverrideApi
import co.novu.api.BlueprintsApi
import co.novu.api.ChangesApi
import co.novu.api.EnvironmentsApi
import co.novu.api.EventsApi
import co.novu.api.ExecutionDetailsApi
import co.novu.api.FeedsApi
import co.novu.api.InboundParseApi
import co.novu.api.IntegrationsApi
import co.novu.api.LayoutsApi
import co.novu.api.MessagesApi
import co.novu.api.NotificationGroupsApi
import co.novu.api.NotificationTemplatesApi
import co.novu.api.NotificationsApi
import co.novu.api.OrganizationsApi
import co.novu.api.SubscribersApi
import co.novu.api.TenantsApi
import co.novu.api.TopicsApi
import co.novu.api.WorkflowsApi
import co.novu.helpers.RetrofitHelper
import okhttp3.logging.HttpLoggingInterceptor

data class NovuConfig(
    var apiKey: String = "",
    var backendUrl: String = "https://api.novu.co/v1/",
    var euBackendUrl: String = "https://eu.api.novu.co/v1/",
    var enableEuVersion: Boolean = false,
    var enableLogging: Boolean = true,
    var apiLogLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BASIC
)

class Novu(
    val config: NovuConfig
) {

    constructor(apiKey: String) : this(NovuConfig(apiKey = apiKey))

    private val retrofitInstance by lazy { RetrofitHelper(config).getInstance() }

    internal val eventsApi by lazy { retrofitInstance.create(EventsApi::class.java) }

    internal val subscribersApi by lazy { retrofitInstance.create(SubscribersApi::class.java) }

    internal val topicsApi by lazy { retrofitInstance.create(TopicsApi::class.java) }

    internal val changesApi by lazy { retrofitInstance.create(ChangesApi::class.java) }

    internal val integrationsApi by lazy { retrofitInstance.create(IntegrationsApi::class.java) }

    internal val executionDetailsApi by lazy { retrofitInstance.create(ExecutionDetailsApi::class.java) }

    internal val feedsApi by lazy { retrofitInstance.create(FeedsApi::class.java) }

    internal val messagesApi by lazy { retrofitInstance.create(MessagesApi::class.java) }

    internal val notificationsApi by lazy { retrofitInstance.create(NotificationsApi::class.java) }

    internal val environmentsApi by lazy { retrofitInstance.create(EnvironmentsApi::class.java) }

    internal val layoutsApi by lazy { retrofitInstance.create(LayoutsApi::class.java) }

    internal val notificationTemplatesApi by lazy { retrofitInstance.create(NotificationTemplatesApi::class.java) }

    internal val workflowsApi by lazy { retrofitInstance.create(WorkflowsApi::class.java) }

    internal val notificationGroupsApi by lazy { retrofitInstance.create(NotificationGroupsApi::class.java) }

    internal val inboundParseApi by lazy { retrofitInstance.create(InboundParseApi::class.java) }

    internal val blueprintsApi by lazy { retrofitInstance.create(BlueprintsApi::class.java) }

    internal val tenantsApi by lazy { retrofitInstance.create(TenantsApi::class.java) }

    internal val organizationsApi by lazy { retrofitInstance.create(OrganizationsApi::class.java) }

    internal val workflowOverrideApi by lazy { retrofitInstance.create(WorkflowOverrideApi::class.java) }
}
