package it.frared.glsitaly;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GlsAddressService {

	@POST("CheckAddress")
	@FormUrlEncoded
	public Call<String> checkAddress(
		@Field("SedeGls") String SedeGls,
		@Field("CodiceClienteGls") String CodiceClienteGls,
		@Field("PasswordClienteGls") String PasswordClienteGls,
		@Field("SiglaProvincia") String SiglaProvincia,
		@Field("Cap") String Cap,
		@Field("Localita") String Localita,
		@Field("Indirizzo") String Indirizzo);
}
