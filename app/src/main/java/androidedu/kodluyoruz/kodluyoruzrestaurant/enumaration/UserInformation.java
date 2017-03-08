package androidedu.kodluyoruz.kodluyoruzrestaurant.enumaration;

/**
 * Created by Gökhan ÖZTÜRK
 * 8.03.2017
 * CodeProject.G@gmail.com
 */
public enum UserInformation {

    INDEX {
        @Override
        public String toString() {
            return "INDEX";
        }
    },
    BASLANGIC {
        @Override
        public String toString() {
            return "BASLANGIC";
        }
    },
    ANAYEMEK {
        @Override
        public String toString() {
            return "ANAYEMEK";
        }
    },
    TATLI {
        @Override
        public String toString() {
            return "TATLI";
        }
    },
    ICECEK {
        @Override
        public String toString() {
            return "ICECEK";
        }
    }
}
