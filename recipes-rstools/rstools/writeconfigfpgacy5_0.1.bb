# Robin Sebastian (https://github.com/robseb) 2019
SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "rstools application to write a new configuration to the FPGA fabric" 
SECTION = "rstools" 
LICENSE = "OPEN" 
PR = "r0"
LIC_FILES_CHKSUM = "file://CHECKSUMFILE;md5=87b5d45e84844e8cc3120f018557015c"
SRC_URI = "gitsm://github.com/robseb/rstoolsCY5.git;protocol=https"
SRCREV = "47fcd2a50cade4a4abd55adf5ccad572a3815ced"
# use  git rev-parse HEAD to update

inherit cmake

S = "${WORKDIR}/git/FPGA-writeConfig"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-writeConfig ${D}${bindir}
}
