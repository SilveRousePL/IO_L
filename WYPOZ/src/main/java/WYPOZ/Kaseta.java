package WYPOZ;

public class Kaseta {
        private final int ID_kasety;
	private final Film Film;
	private int status; // 1= wolna 0= zajeta
	private Zamowienie zamowienie;

        public Kaseta(String[] dane, Film film){
            ID_kasety = Integer.parseInt(dane[0]);
            Film = film; 
            status = 1;
        }
        
        public Kaseta(String dane){
            ID_kasety = Integer.parseInt(dane);
            Film = TFactory.utworz_wzorzec_filmu("1");
            status = 1;
        }
        
        public int getID_kasety() {
            return ID_kasety;
        }

        
        public Film getFilm() {
            return Film;
        }


	public void wypozycz() {
            status = 0;
	}

	public void zwolnij() {
            status = 1;
	}
    
        public boolean czy_wolna() {
            //boolean czy_wolna_temp;
            //czy_wolna_temp = false;
            //if (status == 1)
            //{
            //    czy_wolna_temp = true;
            //}
            //if ((status == 0) && (status != 1))
            //{
            //    czy_wolna_temp = false;
            //}
            //return (czy_wolna_temp == true) ? true : false;
            //return (status == 1) ? true : false;
            return status == 1;
        }

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
            final Kaseta other = (Kaseta) obj;
            return this.ID_kasety == other.ID_kasety;
        }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.ID_kasety;
        return hash;
    }

        @Override
        public String toString() {
            return "Kaseta{" + "ID_kasety=" + ID_kasety + '}';
        }
        
        public long data_zwolnienia() {
            if (!czy_wolna()){
                return zamowienie.data_oddania();
            }else
                return 0;
        }

    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }
       
}