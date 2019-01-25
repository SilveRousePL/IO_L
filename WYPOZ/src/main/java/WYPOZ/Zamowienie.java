package WYPOZ;

import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicInteger;

public class Zamowienie {

	private final int id_zamowienia;
        /*
         * 0=rezerwacja 1=draft(niedokonczone) 2=zamowione 3=wyslane
         * 4=dostarczono 5=zakonczone
         *
         */
	private int status;
	private Uzytkownik uzytkownik;
	private Kaseta kaseta;
	private Timestamp data_spodziewanego_zwrotu;
        private static final AtomicInteger COUNT = new AtomicInteger(0); 

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zamowienie other = (Zamowienie) obj;
        return this.id_zamowienia == other.id_zamowienia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id_zamowienia;
        return hash;
    }
        
        Zamowienie(Uzytkownik uzytk, Kaseta kaseta) {
            id_zamowienia = COUNT.incrementAndGet(); 
            status=2;
            this.kaseta = kaseta;
            this.uzytkownik = uzytk;
            kaseta.setZamowienie(this);
        }
        
        Zamowienie(String id) {
            id_zamowienia = Integer.parseInt(id);
        }

	public int oblicz_kare() {
            if (this.data_spodziewanego_zwrotu!=null)
            {
                int kara = (int) ((System.currentTimeMillis()-this.data_spodziewanego_zwrotu.getTime())
                        /getDayTime())*5;
                return kara>0?kara:0;
            }
            return 0;
	}

	public boolean zakoncz() {
            kaseta.zwolnij();
            status = 5;
            return true;
	}
        
        public boolean do_oddania() {
            return (status==4);
        }
        
        public boolean czy_wolne() {
            return (status==2);
        }
        
        public boolean do_wysylki(){
            return (status==3);
        }
        
        public String kasetaStr(){
           return kaseta.toString();
        }
        
        public void wyslano(){
            data_spodziewanego_zwrotu = new Timestamp(System.currentTimeMillis()
                    + 14 *getDayTime() );
                //    14   dni
            status=4;
        }
        
        public long data_oddania(){
            return data_spodziewanego_zwrotu.getTime();
        }
        
        // tylko na potrzeby testów
        public int getId_zamowienia() {
            return id_zamowienia;
        }

        // tylko na potrzeby testów
        public Uzytkownik getUzytkownik() {
            return uzytkownik;
        }

        // tylko na potrzeby testów
        public Kaseta getKaseta() {
            return kaseta;
        }
        
        private long getDayTime() {
            return 24 * 60 * 60 * 1000;
        }
        
        @Override
        public String toString(){
            return "Zamowienie{id_zamowienia="+id_zamowienia+", kaseta="+this.kasetaStr()+", status="+status+", kara="+this.oblicz_kare()+"}";
        }
}