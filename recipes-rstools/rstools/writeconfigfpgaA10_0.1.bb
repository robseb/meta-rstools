# Robin Sebastian (https://github.com/robseb) 2019
SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "rstools application to write a new configuration to the FPGA fabric A10" 
SECTION = "rstools" 
LICENSE = "GPL-2"
PR = "r0"
LIC_FILES_CHKSUM = "file://CHECKSUMFILE;md5=40739bad7cfc28134e11db94925f75b0" 
SRC_URI = "gitsm://github.com/robseb/rstoolsA10.git;protocol=https"
SRCREV = "f8f8a03433bbf28d1792d07abfa1d5915d3da3c0" 
# use  git rev-parse HEAD to update

inherit cmake

S = "${WORKDIR}/git/FPGA-writeConfig"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-writeConfig ${D}${bindir}
}
