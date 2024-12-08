module com.projetobeneficentecentroespiritafeesperancacaridadejavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;

    requires jakarta.persistence;
    requires org.hibernate.orm.core;


    opens com.projetobeneficentecentroespiritafeesperancacaridadejavafx to javafx.fxml;
    exports com.projetobeneficentecentroespiritafeesperancacaridadejavafx;
}