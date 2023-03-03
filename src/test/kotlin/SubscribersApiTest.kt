package co.novu.api

import co.novu.Novu
import co.novu.dto.request.subscribers.SubscriberRequest
import co.novu.dto.response.subscribers.SubscriberResponse
import co.novu.extensions.*
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.types.shouldBeInstanceOf
import java.math.BigInteger
import java.util.UUID

class SubscribersApiTest : DescribeSpec({
    describe("Get List of subscribers") {

        it("Should get the list of subscribers") {

            Novu(TestVariables().APIKEY).subscribers().run {
                this?.page.shouldBeInstanceOf<BigInteger>()
                this?.totalCount.shouldBeInstanceOf<BigInteger>()
                this?.pageSize.shouldBeInstanceOf<BigInteger>()
                this?.data?.forEach { it.shouldBeInstanceOf<SubscriberResponse>() }
            }
        }
    }

    describe("Create subscriber") {
        it("Should create a subscriber") {

            Novu(TestVariables().APIKEY).createSubscriber(
                subscriberRequest = SubscriberRequest(
                    subscriberId = TestVariables().SUBSCRIBER_ID,
                    firstName = "A",
                    lastName = "B",
                ),
            )
        }
    }

    describe("Get Subscriber Details") {
        it("Should fetch subscriber details") {

            Novu(TestVariables().APIKEY).getSubscriber(TestVariables().SUBSCRIBER_ID)
        }
    }

    describe("Update a Subscriber") {
        it("Should update subscriber details") {

            Novu(TestVariables().APIKEY).updateSubscriber(TestVariables().SUBSCRIBER_ID)
        }
    }

    describe("Delete a Subscriber") {
        it("Should delete a subscriber") {
            Novu(TestVariables().APIKEY).deleteSubscriber(TestVariables().SUBSCRIBER_ID)
        }
    }

    describe("Update Subscriber Credentials") {
        it("Should update credentials of subscriber") {
            Novu(TestVariables().APIKEY).updateSubscriberCredentials(TestVariables().SUBSCRIBER_ID)
        }
    }

    describe("Get Subscriber Preferences") {
        it("Should fetch subscribers preference") {
            Novu(TestVariables().APIKEY).getSubscriberPreferences(TestVariables().SUBSCRIBER_ID)
        }
    }
    describe("Update Subscriber Credentials") {
        it("Should update subscriber credentials") {
            Novu(TestVariables().APIKEY).updateSubscriberPreferences(TestVariables().SUBSCRIBER_ID, TestVariables().TEMPLATE_ID)
        }
    }
    describe("Get Notifications For Subscriber") {
        it("Should get subscriber's notifications") {
            Novu(TestVariables().APIKEY).getNotificationsForSubscriber(TestVariables().SUBSCRIBER_ID)
        }
    }

    describe("Get Unseen Notification For Subscriber") {
        it("Should get unseen notifications for subscriber") {
            Novu(TestVariables().APIKEY).getUnseenNotificationsForSubscriber(TestVariables().SUBSCRIBER_ID)
        }
    }

    describe("Mark Subscriber Message Feed as Seen") {
        it("Should mark subscribers message feed as seen") {
            Novu(TestVariables().APIKEY).markSubscriberMessageFeedAsSeen(TestVariables().SUBSCRIBER_ID, TestVariables().MESSAGE_ID)
        }
    }

    describe("Mark Action Seen") {
        it("Should mark action as seen") {
            Novu(TestVariables().APIKEY).markActionAsSeen(TestVariables().SUBSCRIBER_ID, TestVariables().MESSAGE_ID, TestVariables().TYPE)
        }
    }
})
