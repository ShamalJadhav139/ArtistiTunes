package co.artist.info.network
import com.google.gson.JsonObject
import retrofit2.http.GET


interface ApiInterface {
    @GET("search")
    fun artistiTunes(
        @retrofit2.http.Query("term") term: String
    ): retrofit2.Call<JsonObject>

}
