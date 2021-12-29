FROM openjdk:8-jdk-bullseye

ARG USERNAME=vscode
ARG GROUPNAME=vscode
ARG USER_UID=1000
ARG USER_GID=1000

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y sudo curl vim maven && \
    groupadd --gid $USER_GID $GROUPNAME && \
    useradd -s /bin/bash --uid $USER_UID --gid $USER_GID -m $USERNAME && \
    echo $USERNAME ALL=\(root\) NOPASSWD:ALL > /etc/sudoers.d/$USERNAME && \
    chmod 0440 /etc/sudoers.d/$USERNAME

