package com.example.andre.retrofitexperience;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiInterface {

     /*
     Passo 3: Esta interface contem os métodos de chamada do API.
     Cada método precisa de uma URL e uma anotação de "end point" que representa
     os métodos GET, POST, PUT etc.
     O retorno é uma instância da classe Call.
      */

     @POST("readcontacts.php")
     Call<List<Contact>> getContacts();
}
