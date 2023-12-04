package it.frared.glsitaly;

import it.frared.glsitaly.model.ElencoResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GlsTrackingService {

	@GET("get_xml_track.php")
	public Call<ElencoResponse> getParcelStatus(
		@Query("locpartenza") String sedePartenzaGls,
		@Query("CodCli") String codiceContrattoGls,
		@Query("numsped") String numeroSpedizione);

	@GET("get_xml_track.php")
	public Call<ElencoResponse> getPickupStatus(
		@Query("locpartenza") String sedePartenzaGls,
		@Query("CodCli") String codiceContrattoGls,
		@Query("numrit") String numeroRitiro);
}