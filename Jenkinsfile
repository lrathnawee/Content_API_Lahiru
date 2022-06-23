pipeline {
    agent {
        label 'ctjenkins-node-perf'
    }
    stages {
        stage("Gatling run") {
            steps {
              sh '''
              		  source /etc/environment
              		  docker run \
              		    -u $(id -u jenkins):$(id -g jenkins) \
              		    -i --rm \
              		    -e MAVEN_CONFIG=/var/maven/.m2 \
              		    -e HTTP_PROXY="http://proxy-dev.aws.wiley.com:8080" \
              		    -e HTTPS_PROXY="http://proxy-dev.aws.wiley.com:8080" \
              		    --name contentapi \
              		    -v ${WORKSPACE}/Gatling/contentapi/:/usr/src/mymaven \
              		    -v ~/.m2:/var/maven/.m2 \
              		    -w /usr/src/mymaven \
              		    maven:3.3-jdk-8 mvn clean gatling:test -Dgatling.simulationClass=test.${scenario} -Dduration=${duration} -Dramp_duration_long=${ramp_duration_long} -Dramp_duration_short=${ramp_duration_short}
              		'''
            }
            post {
              always {
              gatlingArchive()
                }
            }
        }
		
        stage("Push Reports to S3") {
            steps {
                sh '''
                cd ${WORKSPACE}/Gatling/contentapi/target/gatling/
                mkdir ./archive
                file_date=$(date "+%F-%T")
                name="gatling-${file_date}"
                tar --exclude="./lastRun.txt" --exclude="./archive" -zcf ./archive/"$name.tar.gz" ./
                aws s3 cp ./archive s3://aws-nonprod-ctqe-performance-team-data/GatlingResults/CAPI/ --recursive --region=us-east-1
                '''
            }
        }
    }
}
