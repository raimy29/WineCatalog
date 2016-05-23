package mobsoft.winecatalog.model;

import retrofit2.Call;
import retrofit2.http.*;


import java.util.List;


public interface DefaultApi {
  
  /**
   * 
   * Returns all `User` objects.
   * @return Call<List<User>>
   */
  
  @GET("users")
  Call<List<User>> listUsers();
    

  
  /**
   * 
   * Returns the `Wine` list for a single `User`.
   * @param id ID of User
   * @return Call<List<Wine>>
   */
  
  @GET("wines/{id}")
  Call<List<Wine>> listWines(
          @Path("id") Long id
  );

  
  /**
   * 
   * Adds a new `Wine` for the given `User`. Duplicates are not allowed.
   * @param id ID of User
   * @param wine Wine to add to the users list
   * @return Call<Wine>
   */
  
  @POST("wines/{id}")
  Call<Wine> addWine(
          @Path("id") Long id, @Body Wine wine
  );

  
  /**
   * 
   * Deletes all Wines of `User` with given ID.
   * @param id ID of User
   * @return Call<Void>
   */
  
  @DELETE("wines/{id}")
  Call<Void> emptyWineList(
          @Path("id") Long id
  );

  
  /**
   * 
   * Deletes `Wine` with ID (if exists) of `User` with given ID.
   * @param userId ID of User
   * @param wineId ID of Wine
   * @return Call<Void>
   */
  
  @DELETE("wines/{user-id}/{wine-id}")
  Call<Void> deleteWine(
          @Path("user-id") Long userId, @Path("wine-id") Long wineId
  );

  
}
