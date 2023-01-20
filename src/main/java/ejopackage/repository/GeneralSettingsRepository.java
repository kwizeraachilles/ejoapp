package ejopackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ejopackage.model.sytem.GeneralSettings;

public interface GeneralSettingsRepository extends JpaRepository<GeneralSettings,String> {
}
