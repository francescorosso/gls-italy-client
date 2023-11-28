package it.frared.glsitaly.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class SpedizioneResponse {

	@JacksonXmlProperty(localName = "NumSped")
	private String numSped;
	@JacksonXmlProperty(localName = "Bda")
	private String bda;
	@JacksonXmlProperty(localName = "DataPartenza")
	private String dataPartenza;
	@JacksonXmlProperty(localName = "StatoSpedizione")
	private String statoSpedizione;
	@JacksonXmlProperty(localName = "Firma")
	private String firma;
	@JacksonXmlProperty(localName = "NumeroColli")
	private String numeroColli;
	@JacksonXmlProperty(localName = "Peso")
	private String peso;

	@JacksonXmlElementWrapper(useWrapping = true, localName = "TRACKING")
	private List<String> tracking;

	public List<SpedizioneStatoResponse> getTrackingSpedizione() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yy", Locale.ITALY);
		DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm", Locale.ITALY);

		List<SpedizioneStatoResponse> statuses = new ArrayList<>();
		Iterator<String> it = tracking.iterator();
		while (it.hasNext()) {
			LocalDate data = LocalDate.parse(it.next(), df);
			LocalTime ora;
			try {
				ora = LocalTime.parse(it.next(), tf);
			} catch (DateTimeParseException e) {
				ora = LocalTime.MIDNIGHT;
			}
			String luogo = it.next();
			String stato = it.next();
			String note = it.next();
			String codice = it.next();

			SpedizioneStatoResponse r = new SpedizioneStatoResponse()
				.setDatetime(LocalDateTime.of(data, ora))
				.setLuogo(luogo)
				.setStato(stato)
				.setNote(note)
				.setCodice(codice);

			statuses.add(r);
		}
		return statuses.stream()
			.sorted(Comparator.comparing(SpedizioneStatoResponse::getDatetime).reversed())
			.collect(Collectors.toList());
	}
}