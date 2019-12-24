# Robin Sebastian (https://github.com/robseb) 2019
SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "rstools application to write a new configuration to the FPGA fabric" 
SECTION = "rstools" 
LICENSE = "GPL-2"
PR = "r0"
LIC_FILES_CHKSUM = "file://CHECKSUMFILE;md5=bff2b7959c4b3958a8ae19f6a39a59ac"
SRC_URI = "gitsm://github.com/robseb/rstoolsCY5.git;protocol=https"
SRCREV = "e319a9fc365131a87586654f3242cf0ba00912bb" 

inherit cmake

S = "${WORKDIR}/git/FPGA-writeConfig"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-writeConfig ${D}${bindir}
}
