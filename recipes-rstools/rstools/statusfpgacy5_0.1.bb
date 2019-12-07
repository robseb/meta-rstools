# Robin Sebastian (https://github.com/robseb) 2019
SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "rstools application to read the Status of the FPGA Fabric with FPGA Manager" 
SECTION = "rstools" 
LICENSE = "OPEN" 
PR = "r0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a974ab7c84f6d979b8b6fa3dc7812ab3"
SRC_URI = "gitsm://github.com/robseb/rstoolsCY5.git;protocol=https"
SRCREV = "89f383ee264f52497b3287c15fb5c72fb40ebada"

inherit cmake

S = "${WORKDIR}/git/FPGA-status"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-status ${D}${bindir}
}
