package it.frared.glsitaly;

import it.frared.glsitaly.model.Base64Binary;
import it.frared.glsitaly.model.CloseParcelsResult;
import it.frared.glsitaly.model.InfoResponse;
import it.frared.glsitaly.model.PickupsResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GlsLabelService {

	@POST("AddParcel")
	@FormUrlEncoded
	public Call<InfoResponse> addParcel(
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
	public Call<CloseParcelsResult> confirmParcel(
		@Field("_xmlRequest") String xml);

	@GET("GetPdfBySped")
	public Call<Base64Binary> getPdfBySped(
		@Query("SedeGls") String SedeGls,
		@Query("CodiceCliente") String CodiceCliente,
		@Query("Password") String Password,
		@Query("CodiceContratto") String CodiceContratto,
		@Query("NumeroSpedizione") String NumeroSpedizione,
		@Query("Bda") String Bda,
		@Query("NumeroCollo") int NumeroCollo,
		@Query("TipoPorto") String TipoPorto);

	@POST("PickUpRequest")
	@FormUrlEncoded
	public Call<PickupsResponse> requestPickup(
		@Field("XMLInfoPickUpRequest") String xml);

	@POST("DeletePickUp")
	@FormUrlEncoded
	public Call<PickupsResponse> deletePickup(
		@Field("XMLInfoDeletePickUp") String xml);
}