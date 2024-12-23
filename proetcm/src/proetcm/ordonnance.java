package proetcm;

public class ordonnance {
	public String nommedicament;
    public String lesdoses;
    public String duree;
  public ordonnance(String nommedicament, String lesdoses, String duree) {
      super();
      this.nommedicament = nommedicament;
      this.lesdoses = lesdoses;
      this.duree = duree;
  }
  public String getNommedicament() {
      return nommedicament;
  }
  public void setNommedicament(String nommedicament) {
      this.nommedicament = nommedicament;
  }
  public String getLesdoses() {
      return lesdoses;
  }
  public void setLesdoses(String lesdoses) {
      this.lesdoses = lesdoses;
  }
  public String getDuree() {
      return duree;
  }
  public void setDuree(String duree) {
      this.duree = duree;
  }


   //don't forget the scanner.close(); when using this class;
  @Override
  public String toString() {
      return "Ordonnance {" +
             "Nom du médicament='" + nommedicament + "" +
             ", Doses='" + lesdoses + "" +
             ", Durée='" + duree + "" +
             '}';
  }
  

}
