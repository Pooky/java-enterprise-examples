package org.examples.jasper.entity;

public class Faktura {

	private String vs;
	private String celkovaCena;
	private String datumVystaveni;
	private String datumSplatnosti;
	
	private Address dodavatelAdresa;
	private Address odberatelAdresa;
	
	public String getVs() {
		return vs;
	}
	public void setVs(String vs) {
		this.vs = vs;
	}
	public String getCelkovaCena() {
		return celkovaCena;
	}
	public void setCelkovaCena(String celkovaCena) {
		this.celkovaCena = celkovaCena;
	}
	public String getDatumVystaveni() {
		return datumVystaveni;
	}
	public void setDatumVystaveni(String datumVystaveni) {
		this.datumVystaveni = datumVystaveni;
	}
	public String getDatumSplatnosti() {
		return datumSplatnosti;
	}
	public void setDatumSplatnosti(String datumSplatnosti) {
		this.datumSplatnosti = datumSplatnosti;
	}
	public Address getDodavatelAdresa() {
		return dodavatelAdresa;
	}
	public void setDodavatelAdresa(Address dodavatelAdresa) {
		this.dodavatelAdresa = dodavatelAdresa;
	}
	public Address getOdberatelAdresa() {
		return odberatelAdresa;
	}
	public void setOdberatelAdresa(Address odberatelAdresa) {
		this.odberatelAdresa = odberatelAdresa;
	}

	
	
}