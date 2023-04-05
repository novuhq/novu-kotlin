# Novu Kotlin client library

This is a Kolin client library for communicating with the [Novu API](https://api.novu.co/api).

## Installation
Maven users
```maven
//Add sonatype release repositories
<repositories>
    ...
    <repository>
        <id>sonatype</id>
        <url>https://s01.oss.sonatype.org/content/repositories/releases/</url> // for release
        or 
        <url>https://s01.oss.sonatype.org/content/repositories/snapshots/</url> // for snapshot
    </repository>
</repositories>

// add dependency
<dependency>
    <groupId>io.github.crashiv</groupId>
    <artifactId>novu-kotlin</artifactId>
    <version>0.1.1-SNAPSHOT</version>
</dependency>
```
Then run `mnv install`.


Gradle users
```gradle
//Add sonatype release repositories
repositories {
    ...
    maven { url "https://s01.oss.sonatype.org/content/repositories/releases/" }
}

// add dependency
implementation("io.github.crashiv:novu-kotlin:0.1.1-SNAPSHOT")
```
then run `gradlew build`


## Usage

To use the library, first initialize the client with your API token:

```kotlin
// without changing the backendUrl
import co.novu.Novu
import co.novu.extentions.environments

fun main() 
{
    val novu = Novu(apiKey = "af3749ea80b67bf2c4f267084b197f98")
    val environment = novu.environments()
    println(environment)
}

```
```kotlin
// with config param
import co.novu.Novu
        import co.novu.NovuConfig
        import co.novu.extentions.environments

fun main() {
    val config = NovuConfig(backendUrl = "http://localhost:8080/v1/")
    val novu = Novu(apiKey = "af3749ea80b67bf2c4f267084b197f98",config)
    val environment = novu.environments()
    println(environment)
} 
```

You can then call methods on the client to interact with the Novu API:

```kotlin
novu.subscribers()
```

## List of all methods

The client methods map directly to the Novu API endpoints. Here's a list of all the available methods. Check [the API docs](https://docs.novu.co/api/overview) for list of available `methods`.

### Changes

- `changes(query = {})`
- `countChanges()`
- `applyBulkChanges()`
- `applyChange(change_id)`

### Environments

- `currentEnvironment()`
- `createEnvironment(body)`
- `environments()`
- `updateEnvironment(environment_id, body)`
- `apiKeys()`
- `regenerate_api_keys()`
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
- `deleteFeed(feed_id)`

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
- `topics(query = {})`
- `addSubscribers(topicKey, body)`
- `removeSubscribers(topicKey, body)`
- `topic(topicKey)`
- `renameTopic(topicKey, body)`

### For more information about these methods and their parameters, see the [API documentation](https://docs.novu.co/api/overview).

## Contributing

Bug reports and pull requests are welcome on GitHub at https://github.com/Crashiv/novu-kotlin
