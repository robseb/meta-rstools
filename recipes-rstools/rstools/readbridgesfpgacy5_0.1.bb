# Robin Sebastian (https://github.com/robseb) 2019
SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "rstools application to read any bridge to FPGA address" 
SECTION = "rstools" 
LICENSE = "OPEN" 
PR = "r0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a974ab7c84f6d979b8b6fa3dc7812ab3"
SRC_URI = "gitsm://github.com/robseb/rstoolsCY5.git;protocol=https"
SRCREV = "89f383ee264f52497b3287c15fb5c72fb40ebada" 
# use  git rev-parse HEAD to update

inherit cmake

S = "${WORKDIR}/git/FPGA-readBrdige"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-readBrdige ${D}${bindir}
}
