# Robin Sebastian (https://github.com/robseb) 2019
SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "rstools application to write to any HPS-FPGA Bridge address" 
SECTION = "rstools" 
LICENSE = "OPEN" 
PR = "r0"
LIC_FILES_CHKSUM = "file://CHECKSUMFILE;md5=bff2b7959c4b3958a8ae19f6a39a59ac"
SRC_URI = "gitsm://github.com/robseb/rstools.git;protocol=https"
SRCREV = "b19c436f4d0958b3072da12f168c9eed38f4c63e" 
# use  git rev-parse HEAD to update

inherit cmake

S = "${WORKDIR}/git/FPGA-WriteBridge"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-WriteBridge ${D}${bindir}
}
