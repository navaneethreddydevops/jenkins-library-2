/* jenkins.groovy
   ##################################################
   # Created by Lin Ru at 2018.10.01 22:00          #
   #                                                #
   # A Part of the Project jenkins-library          #
   #  https://github.com/Statemood/jenkins-library  #
   ##################################################
*/

def call(Map args = [:]){
    log.info "Pipeline Go!"

    settings.parameters = args
    loadLocalSettings()

    echo "Print parameters"
    println settings.parameters

    stages.controller()
}

    def loadLocalSettings(){
        if (SETTINGS) {
            try {
                if (fileExists(SETTINGS)) {
                    log.info "Loading local settings"

                    load(SETTINGS)

                    log.info "Local settings loaded"
                }
                else {
                    log.warning "File not found: $SETTINGS"
                }
            }
            catch (e) {
                throw e 
            }
        }
    }
