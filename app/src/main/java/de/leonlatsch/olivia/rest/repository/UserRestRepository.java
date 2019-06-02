package de.leonlatsch.olivia.rest.repository;

import java.util.List;

import de.leonlatsch.olivia.entity.User;
import de.leonlatsch.olivia.transfer.TransferUser;
import de.leonlatsch.olivia.transfer.UserAuthenticator;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserRestRepository {

    @GET("users")
    Call<List<TransferUser>> getAll();

    @GET("users/getByUid/{uid}")
    Call<TransferUser> getbyUid(@Path("name") int uid);

    @GET("users(getByEmail/{email}")
    Call<TransferUser> getByEmail(@Path("email") String email);

    @GET("users/getByUsername/{username}")
    Call<TransferUser> getByUsername(@Path("username") String username);

    @PUT("users/update")
    Call<String> update(@Body User user);

    @DELETE("users/delete/{uid}")
    Call<String> delete(@Path("uid") int uid);

    @GET("users/checkUsername/{username}")
    Call<String> checkUsername(@Path("username") String username);

    @GET("users/checkEmail/{email}")
    Call<String> checkEmail(@Path("email") String email);

    @GET("users/auth")
    Call<String> auth(@Body UserAuthenticator authenticator);
}
