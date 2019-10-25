FROM payara/micro
COPY ./target/cines.war $DEPLOY_DIR
