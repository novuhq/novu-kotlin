package co.novu.api

import co.novu.Novu
import co.novu.dto.request.events.BroadcastEventRequest
import co.novu.dto.request.events.TriggerEventRequest
import co.novu.dto.request.subscribers.SubscriberRequest
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldNotBeBlank

class EventsApiTest : DescribeSpec({

    describe("Trigger Event Tests") {

        it("Should trigger an event to subscriberId") {

            Novu(TestVariables().APIKEY).trigger(
                TriggerEventRequest(
                    name = TestVariables().EXISTING_CHANNEL,
                    to = "subid",
                    payload = mapOf(),
                ),
            )
                .run {
                    this?.data?.acknowledged shouldBe true
                    this?.data?.status shouldBe "processed"
                    this?.data?.transactionId.shouldNotBeBlank()
                }
        }

        it("Should trigger an event to subscriberId with specified transactionId") {
            Novu(TestVariables().APIKEY).trigger(
                TriggerEventRequest(
                    name = TestVariables().EXISTING_CHANNEL,
                    to = "subid",
                    payload = mapOf(),
                    transactionId = TestVariables().TRANSACTION_ID,
                ),
            )
                .run {
                    this?.data?.acknowledged shouldBe true
                    this?.data?.status shouldBe "processed"
                    this?.data?.transactionId.shouldNotBeBlank()
                    this?.data?.transactionId shouldBe TestVariables().TRANSACTION_ID
                }
        }

        it("Should trigger an event to subscriberId to non existing channel") {
            Novu(TestVariables().APIKEY).trigger(
                TriggerEventRequest(
                    name = TestVariables().NON_EXISTING_CHANNEL,
                    to = "subid",
                    payload = mapOf(),
                ),
            )
                .run {
                    this?.data?.acknowledged shouldBe true
                    this?.data?.status shouldBe "template_not_found"
                    this?.data?.transactionId.shouldBeNull()
                }
        }

        it("Should trigger an event to list of subscriberId") {
            Novu(TestVariables().APIKEY).trigger(
                TriggerEventRequest(
                    name = TestVariables().EXISTING_CHANNEL,
                    to = listOf("sub1", "sub2"),
                    payload = mapOf(),
                ),
            ).run {
                this?.data?.status shouldBe "processed"
            }
        }

        it("Should trigger an event to subscriberDTO") {
            Novu(TestVariables().APIKEY).trigger(
                TriggerEventRequest(
                    name = TestVariables().EXISTING_CHANNEL,
                    to = SubscriberRequest(subscriberId = "id", firstName = "test", lastName = "test"),
                    payload = mapOf(),
                ),
            ).run {
                this?.data?.acknowledged shouldBe true
                this?.data?.status shouldBe "processed"
            }
        }
    }

    describe("Bulk Trigger Test") {
        it("Should trigger events in bulk") {
            Novu(TestVariables().APIKEY).bulkTrigger(
                listOf(
                    TriggerEventRequest(
                        name = TestVariables().EXISTING_CHANNEL,
                        to = SubscriberRequest(subscriberId = "id", firstName = "test", lastName = "test"),
                        payload = mapOf(),
                    ),
                ),
            ).run {
                this?.data?.forEach { it.acknowledged shouldBe true }
                this?.data?.forEach { it.status shouldBe "processed" }
            }
        }
    }

    describe("Broadcast Event Tests") {

        it("Should broadcast an event") {
            Novu(TestVariables().APIKEY).broadcast(
                BroadcastEventRequest(name = TestVariables().EXISTING_CHANNEL, payload = mapOf()),
            ).run {
                this?.data?.status shouldBe "processed"
                this?.data?.acknowledged shouldBe true
            }
        }
    }

    describe("Cancel event trigger test") {
        it("Should cancel an event trigger") {
            Novu(TestVariables().APIKEY).cancelTriggerEvent(TestVariables().TRANSACTION_ID)
                .run {
                    this?.data shouldBe false
                }
        }
    }
})
