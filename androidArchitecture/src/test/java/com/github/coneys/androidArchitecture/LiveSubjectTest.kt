package com.github.coneys.androidArchitecture

import com.github.coneys.androidArchitecture.publisher.LiveSubject


class LiveSubjectTest : LiveTest() {
    init {
        "On posting after listening, value should be there"{

            val subject = LiveSubject<String>()
            val test = subject.test()

            subject.post("abc")

            test.assertValue("abc")

        }

        "On posting before listening, value should be there "{

            val subject = LiveSubject<String>()

            subject.post("abc")

            val test = subject.test()

            test.assertValue("abc")

        }

        "Old listener shouldn't be notified when cached value is changed"{

            val subject = LiveSubject<String>()

            subject.post("beforeChange")

            val test = subject.test()

            subject.setNewCachedValue("doChange")

            test.assertValue("beforeChange")

        }

        "New listener should have newest value"{

            val subject = LiveSubject<String>()

            subject.post("beforeChange")

            val test = subject.test()

            subject.setNewCachedValue("doChange")

            val test2 = subject.test()

            test.assertValue("beforeChange")
            test2.assertValue("doChange")
        }
    }
}



