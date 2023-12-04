package it.frared.glsitaly;

import it.frared.glsitaly.model.AddressList;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GlsAddressService {

	@POST("CheckAddress")
	@FormUrlEncoded
	public Call<AddressList> checkAddress(
		@Field("SedeGls") String SedeGls,
		@Field("CodiceClienteGls") String CodiceClienteGls,
		@Field("PasswordClienteGls") String PasswordClienteGls,
		@Field("Indirizzo") String Indirizzo,
		@Field("Localita") String Localita,
		@Field("Cap") String Cap,
		@Field("SiglaProvincia") String SiglaProvincia);
}
