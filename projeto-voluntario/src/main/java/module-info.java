module com.projetobeneficentecentroespiritafeesperancacaridadejavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.projetobeneficentecentroespiritafeesperancacaridadejavafx to javafx.fxml;
    exports com.projetobeneficentecentroespiritafeesperancacaridadejavafx;
}