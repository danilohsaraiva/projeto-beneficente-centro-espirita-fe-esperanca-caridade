module com.projetobeneficentecentroespiritafeesperancacaridadejavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;

    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model to org.hibernate.orm.core;
    opens com.projetobeneficentecentroespiritafeesperancacaridadejavafx to javafx.fxml;
    opens com.projetobeneficentecentroespiritafeesperancacaridadejavafx.controller to javafx.fxml;
    opens com.projetobeneficentecentroespiritafeesperancacaridadejavafx.service to javafx.fxml;
    opens com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos to javafx.fxml;
    opens com.projetobeneficentecentroespiritafeesperancacaridadejavafx.view to javafx.fxml;

    exports com.projetobeneficentecentroespiritafeesperancacaridadejavafx;
}