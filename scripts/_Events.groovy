eventCompileEnd = {
	if(buildSettings.baseDir.getPath().endsWith('grails-method-transactional')) {
		ant.copyfile(src: "${buildSettings.baseDir}/grails-app/conf/hibernate/hibernate.cfg.xml",
			dest: "${buildSettings.resourcesDir}/hibernate.cfg.xml",
			forceoverwrite: true)
	}
}
