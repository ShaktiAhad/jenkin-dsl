FROM jenkins/jenkins:latest
ARG PROCESSOR
USER root
ADD check_arg.sh cli_download.sh /tmp
RUN chmod u+x /tmp/check_arg.sh && \
    chmod u+x /tmp/cli_download.sh
RUN /tmp/check_arg.sh "$PROCESSOR" && \
    /tmp/cli_download.sh "$PROCESSOR"

RUN apt update && apt upgrade -y && \
    apt install vim -y && \
    apt install python3 -y && \
    apt -y install python3-pip --ignore-missing || :

RUN tar -xvf /tmp/google-cloud-sdk.tar.gz -C /tmp/
RUN sh /tmp/google-cloud-sdk/install.sh -q
ENV PATH="/tmp/google-cloud-sdk/bin:${PATH}"

RUN unzip awscliv2.zip
RUN ./aws/install
RUN rm /tmp/check_arg.sh /tmp/cli_download.sh