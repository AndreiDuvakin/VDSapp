import com.example.vdsapp.network.models.responses.Account
import retrofit2.http.GET
import retrofit2.http.Query

interface AccountInfoGet {
    @GET("account")
    suspend fun accountInfoGet(
        @Query("X-Token") token: String
    ) : Account
}