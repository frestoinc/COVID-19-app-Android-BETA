package uk.nhs.nhsx.sonar.android.client

import com.android.volley.Request.Method.POST
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import uk.nhs.nhsx.sonar.android.client.http.HttpClient
import uk.nhs.nhsx.sonar.android.client.http.TestQueue

class AcknowledgementsApiTest {

    private val requestQueue = TestQueue()
    private val httpClient = HttpClient(requestQueue)
    private val acknowledgementsApi = AcknowledgementsApi(httpClient)

    @Test
    fun testSend() {
        acknowledgementsApi.send("https://api.example.com/ack/10012")

        val request = requestQueue.lastRequest
        assertThat(request.method).isEqualTo(POST)
        assertThat(request.url).isEqualTo("https://api.example.com/ack/10012")
    }
}
