package lf2.jtp;

interface Obserwowany {
    public void dodajObserwatora(Obserwator o);
    public void usunObserwatora(Obserwator o);
    public void powiadamiajObserwatorow(Object o);
}