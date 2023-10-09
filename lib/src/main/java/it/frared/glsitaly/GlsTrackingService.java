package it.frared.glsitaly;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GlsTrackingService {
	
	// https://www.gls-italy.com/index.php?option=com_gls&view=track_e_trace&mode=search&diretto=yes&locpartenza=CN&numsped=630135543

	@GET("get_xml_track.php")
	public Call<String> getSpedizioneStatus(
		@Query("locpartenza") String sedePartenzaGls,
		@Query("CodCli") String codiceContrattoGls,
		@Query("numsped") String numeroSpedizione);

	@GET("get_xml_track.php")
	public Call<String> getRitiroStatus(
		@Query("locpartenza") String sedePartenzaGls,
		@Query("CodCli") String codiceContrattoGls,
		@Query("numrit") String numeroRitiro);
}
