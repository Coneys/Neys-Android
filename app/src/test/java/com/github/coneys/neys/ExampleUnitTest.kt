package com.github.coneys.neys

import com.github.coneys.neys.test.TestPost
import io.kotlintest.specs.StringSpec
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import java.io.File
import java.io.FileOutputStream
import java.net.URL

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest : StringSpec() {


    init {
        "try to send"{
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit
                .Builder()
                .baseUrl("http://192.168.1.38:8080/")
                .client(client)
                .build()

            val testPost = retrofit.create<TestPost>()

            val file = downloadPicture()
            uploadFile(file, testPost)
        }
    }

    fun downloadToFile(link: String, file: File) {
        URL(link).openStream().use { input ->
            FileOutputStream(file).use { output ->
                input.copyTo(output)
            }
        }
    }

    private fun downloadPicture(): File {

        val dir = File("images").also { it.mkdir() }
        val file = File(dir, "abc.jpeg")
        //  downloadToFile("https://images.pexels.com/photos/46710/pexels-photo-46710.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",file)

        return file

    }

    fun uploadFile(file: File, testPost: TestPost) {


        val requestFile = RequestBody.create(
            MediaType.parse("png"),
            file
        )

        // MultipartBody.Part is used to send also the actual file name
        val body = MultipartBody.Part.createFormData("picture", file.name, requestFile)

        // add another part within the multipart request
        val titleString = "Recipe"
        val title = RequestBody.create(
            okhttp3.MultipartBody.FORM, titleString
        )

        val result = testPost.upload(body, title).execute()
    }

}
