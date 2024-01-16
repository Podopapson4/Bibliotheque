package com.podosoft.bibliotheque.Listeners;

import retrofit2.Response;

public interface GeneralResponseListener {
    void didFetch(Response<?> response);
    void didError(Response<?> response);

    void didFail(String message);
}
