# Robin Sebastian (https://github.com/robseb) 2019
SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "rstools application to write to any HPS-FPGA Bridge address" 
SECTION = "rstools" 
LICENSE = "GPL-2"
PR = "r0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=40739bad7cfc28134e11db94925f75b0"
SRC_URI = "gitsm://github.com/robseb/rstoolsCY5.git;protocol=https"
SRCREV = "e319a9fc365131a87586654f3242cf0ba00912bb" 
# use  git rev-parse HEAD to update

inherit cmake

S = "${WORKDIR}/git/FPGA-writeBridge"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-writeBridge ${D}${bindir}
}
