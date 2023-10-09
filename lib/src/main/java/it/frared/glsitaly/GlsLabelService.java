package it.frared.glsitaly;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GlsLabelService {
	
	@POST("AddParcel")
	@FormUrlEncoded
	public Call<String> addParcel(
		@Field("XMLInfoParcel") String xml);

	@POST("DeleteSped")
	@FormUrlEncoded
	public Call<Void> deleteParcel(
		@Field("SedeGls") String SedeGls,
		@Field("CodiceClienteGls") String CodiceClienteGls,
		@Field("PasswordClienteGls") String PasswordClienteGls,
		@Field("NumSpedizione") String NumSpedizione);

	@POST("CloseWorkDayByShipmentNumber")
	@FormUrlEncoded
	public Call<String> confirmParcel(
		@Field("_xmlRequest") String xml);

	@GET("GetPdfBySped")
	public Call<String> getPdfBySped(
		@Query("SedeGls") String SedeGls,
		@Query("CodiceCliente") String CodiceCliente,
		@Query("Password") String Password,
		@Query("CodiceContratto") String CodiceContratto,
		@Query("NumeroSpedizione") String NumeroSpedizione,
		@Query("Bda") String Bda,
		@Query("NumeroCollo") int NumeroCollo);

	@POST("PickUpRequest")
	@FormUrlEncoded
	public Call<String> requestPickup(
		@Field("XMLInfoPickUpRequest") String xml);

	@POST("DeletePickUp")
	@FormUrlEncoded
	public Call<String> deletePickup(
		@Field("XMLInfoDeletePickUp") String xml);
}
