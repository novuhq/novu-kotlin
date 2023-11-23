<div align="center">
  <a href="https://novu.co" target="_blank">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="https://user-images.githubusercontent.com/2233092/213641039-220ac15f-f367-4d13-9eaf-56e79433b8c1.png">
    <img src="https://user-images.githubusercontent.com/2233092/213641043-3bbb3f21-3c53-4e67-afe5-755aeb222159.png" width="280" alt="Logo"/>
  </picture>
  </a>
</div>

# Novu Kotlin SDK

> The [Novu Kotlin](https://novu.co) SDK provides a fluent and expressive interface for interacting with [Novu's API](https://api.novu.co/api) and managing notifications.

## Installation

**Maven users:**

```xml
<!--add dependency-->
<dependency>
    <groupId>co.novu</groupId>
    <artifactId>novu-kotlin</artifactId>
    <version>1.1.0</version>
</dependency>
```

**Gradle users:**

```kotlin
//Kotlin
//add dependency
implementation("co.novu:novu-kotlin:1.1.0")
```

```groovy
//Groovy
//add dependency
implementation 'co.novu:novu-kotlin:1.1.0'
```

Sync your project, and you should have the artifacts downloaded.

## Usage

To use the library, first initialize the client with your API token:

```kotlin
// without changing the backend URL
import co.novu.Novu
import co.novu.extensions.environments

fun main() {
    val novu = Novu(apiKey = "API_KEY")
    val environment = novu.environments()
    println(environment)
}

```
```kotlin
// with config param
import co.novu.Novu
import co.novu.NovuConfig
import co.novu.extensions.environments

fun main() {
    val config = NovuConfig(backendUrl = "URL", apiKey = "API_KEY")
    val novu = Novu(config)
    val environment = novu.environments()
    println(environment)
} 
```

You can then call methods on the client to interact with the Novu API:

```kotlin
novu.subscribers()
```

## List of all methods

The client methods map directly to the Novu API endpoints. Here is a list of all the available methods. Check [the API docs](https://docs.novu.co/api-reference/overview) for list of available `methods`.

### Changes

- `changes(query = {})`
- `countChanges()`
- `applyBulkChanges()`
- `applyChange(changeId)`

### Environments

- `currentEnvironment()`
- `createEnvironment(body)`
- `environments()`
- `updateEnvironment(environmentId, body)`
- `apiKeys()`
- `regenerateApiKeys()`
- `updateWidgetSettings(body)`

### Events

- `triggerEvent(body)`
- `triggerBulkEvent(body)`
- `broadcastEvent(body)`
- `cancelTriggeredEvent(transactionId)`

### Execution Details

- `executionDetails(query = {})`

### Feeds

- `createFeed(body)`
- `feeds()`
- `deleteFeed(feedId)`

### Inbound Parse

- `validateMxRecordSetupForInboundParse()`

### Integrations

- `integrations()`
- `createIntegration(body)`
- `activeIntegrations()`
- `webhookProviderStatus(providerId)`
- `updateIntegration(integrationId, body)`
- `deleteIntegration(integrationId)`
- `channelLimit(channelType)`
- `inAppStatus()`

### Layouts

- `createLayout(body) `
- `layouts(query = {})`
- `layout(layoutId)`
- `deleteLayout(layoutId)`
- `updateLayout(layoutId, body)`
- `makeDefaultLayout(layoutId)`

### Messages

- `messages(query = {})`
- `deleteMessage(messageId)`

### Notification Groups

- `createNotificationGroup(body)`
- `notificationGroups()`

### Notification Templates

- `notificationTemplates(query = {})`
- `createNotificationTemplate(body)`
- `updateNotificationTemplate(templateId, body)`
- `deleteNotificationTemplate(templateId)`
- `notificationTemplate(templateId)`
- `notificationTemplateBlueprint(templateId)`
- `createNotificationTemplateBlueprint(templateId)`
- `updateNotificationTemplateStatus(templateId, body)`

### Notification

- `notifications(query = {})`
- `notificationsStats()`
- `notificationsGraphStats(query = {})`
- `notification(notificationId)`

### Subscribers

- `subscribers(query = {}) `
- `createSubscriber(body)`
- `createSubscriberBulk(body)`
- `subscriber(subscriberId)`
- `updateSubscriber(subscriberId, body)`
- `deleteSubscriber(subscriberId)`
- `updateSubscriberCredentials(subscriberId, body)`
- `updateSubscriberOnlineStatus(subscriberId, body)`
- `subscriberPreferences(subscriberId)`
- `updateSubscriberPreference(subscriberId, templateId, body)`
- `subscriberNotificationFeed(subscriberId, query = {})`
- `subscriberUnseenNotificationCount(subscriberId, query = {})`
- `markSubscriberFeedSeen(subscriberId, body)`
- `markMessageActionSeen(subscriberId, messageId, type)`

### Topics

- `createTopic(body)`
- `filterTopics(page, pageSize, key)`
- `addSubscribers(topicKey, body)`
- `removeSubscribers(topicKey, body)`
- `checkSubscriber(topicKey, externalSubscriberId)`
- `topic(topicKey)`
- `renameTopic(topicKey, body)`
- `deleteTopic(topicKey)`

### Blueprints

- `getBlueprintsByCategory()`
- `getBlueprint(templateId)`

### Tenants

- `getTenants(page, limit)`
- `createTenant(body)`
- `getTenant(identifier)`
- `updateTenant(identifier)`
- `deleteTenant(identifier)`

### Organizations

- `createOrganization(body)`
- `fetchAllOrganizations()`
- `updateOrganizationName(body)`
- `fetchCurrentOrganization()`
- `removeMemberWithId(identifier)`
- `updateMemberRole(identifier, body)`
- `fetchMembersOfOrganization()`
- `updateOrganizationBrand(body)`

### For more information about these methods and their parameters, see the [API documentation](https://docs.novu.co/api-reference/overview).

## Contributing

Feature requests, bug reports and pull requests are welcome. Please create an [issue](https://github.com/novuhq/novu-kotlin/issues).

## Support and Feedback

Be sure to visit the Novu official [documentation website](https://docs.novu.co/docs) for additional information about our API.
If you need additional assistance, join our Discord server [here](https://discord.novu.co).

## License

Novu Kotlin SDK is licensed under the MIT License - see the [LICENSE](https://github.com/novuhq/novu-kotlin/blob/main/LICENSE.md) file for details.

## Contributors

<a href="https://github.com/novuhq/novu-kotlin/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=novuhq/novu-kotlin&max=500&columns=20" alt="Contributors"/>
</a>
