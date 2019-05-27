package com.example.cupidshuffle.services;

import com.example.cupidshuffle.model.UserProfilesAPI;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserProfileService {

    @GET("InquisitiveMindHasToKnow/6ad4c3e83c0bde52c0ba369e49091898/raw/e784eafea0d9ff8f64be49e4c17840e00cd4b4c7/CupidShuffleProfiles.txt")
    Call<UserProfilesAPI> getProfiles();
}
