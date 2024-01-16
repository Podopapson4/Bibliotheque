package com.podosoft.bibliotheque.Requests;

import com.podosoft.bibliotheque.Listeners.GeneralResponseListener;
import com.podosoft.bibliotheque.MyHelpers.GeneralHelper;
import com.podosoft.bibliotheque.Responses.GeneralResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.io.IOException;

public class GeneralRequest {
    Retrofit retrofit = GeneralHelper.retrofitGoogleBooksApi();

    // Get Books Volumes
    public GeneralResponse getBooksVolumes(String query) {
        CallGetBooksVolumes callGetBooksVolumes = retrofit.create(CallGetBooksVolumes.class);
        Call<GeneralResponse> call = callGetBooksVolumes.callGetBooksVolumes(query);

        try {
            Response<GeneralResponse> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public GeneralResponse getBooksVolumesPage(String query, int startIndex, int maxResults) {
        CallGetBooksVolumesPage callGetBooksVolumesPage = retrofit.create(CallGetBooksVolumesPage.class);
        Call<GeneralResponse> call = callGetBooksVolumesPage.callGetBooksVolumesPage(query, startIndex, maxResults);

        try {
            Response<GeneralResponse> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    //  ****************        Interfaces

    // Call Get BooksVolumes
    interface CallGetBooksVolumesPage {
        @GET("volumes")
        Call<GeneralResponse> callGetBooksVolumesPage(
                @Query("q") String query,
                @Query("startIndex") int startIndex,
                @Query("maxResults") int maxResults
        );
    }

    // Call Get BooksVolumes
    interface CallGetBooksVolumes {
        @GET("volumes")
        Call<GeneralResponse> callGetBooksVolumes(
                @Query("q") String query
        );
    }
}
