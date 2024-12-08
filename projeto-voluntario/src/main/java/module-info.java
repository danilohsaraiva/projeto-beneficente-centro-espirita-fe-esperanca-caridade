module com.projetobeneficentecentroespiritafeesperancacaridadejavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.projetobeneficentecentroespiritafeesperancacaridadejavafx to javafx.fxml;
    exports com.projetobeneficentecentroespiritafeesperancacaridadejavafx;
}